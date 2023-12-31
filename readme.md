# Общее описание
Задача этой программы - проверить корректность личного кода.

Личный код состоит из ровно 11 цифр, поэтому длина данной строки не должна превышать 11 символов. Значения цифр:

# Первая цифра:
1 - мужчина, родившийся с 1800 по 1899 год 2 - женщина, родившаяся с 1800 по 1899 год 3 - мужчина, родившийся с 1900 по 1999 год 4 - женщина, родившаяся с 1900 по 1999 год 5 - мужчина, родившийся с 2000 по 2099 год 6 - женщина, родившаяся с 2000 по 2099 год

# Вторая и третья цифры:
Две последние цифры года рождения (например, 01, 75 и так далее, до 99).

# Четвертая и пятая цифры:
Номер месяца рождения (например, январь - 01, февраль - 02 и так далее, до 12).

# Шестая и седьмая цифры:
Номер дня рождения (например, 01, 08, 20 и так далее, в зависимости от месяца).

# Восьмая, девятая и десятая цифры:
Порядковый номер рожденного в этот день (например, 000, 012 и так далее, до 999).

# Одиннадцатая цифра:
Контрольная цифра, которая находится в диапазоне от 0 до 9. Для этого есть специальный алгоритм

# Алгоритм
Контрольная цифра личного кода формируется методом "Модуль 11", используя веса первого и второго порядка:

Вес первого порядка: 1 2 3 4 5 6 7 8 9 1

Вес второго порядка: 3 4 5 6 7 8 9 1 2 3

Это означает, что десять первых цифр личного кода умножаются на соответствующий вес первого порядка, и полученные произведения суммируются. Затем сумма делится на 11. Если остаток от деления меньше 10, то этот остаток становится контрольной цифрой.

Если остаток равен 10, то десять первых цифр личного кода умножаются на соответствующий вес второго порядка, и полученные произведения суммируются. Затем сумма делится на 11. Если остаток от деления меньше 10, то этот остаток становится контрольной цифрой.

Если остаток равен 10, то контрольная цифра равна 0.

Пример: Пусть дан личный код 37605030299 для проверки: Сумма = 1×3 + 2×7 + 3×6 + 4×0 + 5×5 + 6×0 + 7×3 + 8×0 + 9×2 + 1×9 = 108. Остаток 108 при делении на 11 равен 9. (108/11 ~ 9,8. Целая часть равна 9. Итак, 9*11 = 99. Вычитая 108 - 99 = 9, это и есть остаток).

Следовательно, контрольная цифра для личного кода 37605030299 должна быть равна 9.

Задача программы - проверить, соответствует ли данная строка структуре и правилам личного кода и вернуть результат проверки.

ДАНЫ ТОЛЬКО ОСНОВНЫЕ МЕТОДЫ, СОЗДАВАЙТЕ САМИ ВСПОМОГАТЕЛЬНЫЕ МЕТОДЫ