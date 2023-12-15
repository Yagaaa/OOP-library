package ru.vsu.cs.dpu;

public class Phrases {
    String YES = "Да";
    String NO = "Нет";
    String[] MENU = {"Команды", "Добавить книгу", "Найти Книгу", "Удалить Книгу", "Загрузить Книги", "Редактировать Библиотеку",
            "Выход"};
    String FIND_OR_TAKE_BOOK = "Знаете ли вы расположение книги?";
    String ROOM_ADD_SUCCESS = "Комната добавлена. Количество комнат в библиотеке: ";
    String BOOKCASE_ADD = "В какую комнаты вы хотите добавить шкаф?";
    String BOOKCASE_ADD_SHELVES = "Сколько полок должно быть в шкафу?";
    String BOOKCASE_ADD_CAPACITY = "Сколько книг может уместиться на полке?";
    String BOOKCASE_ADD_SUCCESS = "Шкаф добавлен. Количество шкафов в комнате: ";
    String ROOM_REMOVE = "Какую комнату вы хотите удалить?";
    String ROOM_REMOVE_SUCCESS = "Комната удалена. Количество комнат в библиотеке: ";
    String BOOKCASE_REMOVE = "В какой комнате вы хотите удалить шкаф?";
    String BOOKCASE_REMOVE_ROOM = "Какой шкаф вы хотите удалить?";
    String BOOKCASE_REMOVE_SUCCESS = "Шкаф удалён. Количество шкафов в комнате: ";
    String LIBRARY_CLEARED = "Библиотека очищена";
    String INPUT_FILE_PATH = "Введите расположение файла";
    String BOOKS_LOADED = "Книги успешно загружены";
    String[] LIBRARY_EDIT_OPTIONS = {"Что вы хотите сделать?", "Добавить комнату", "Добавить шкаф", "Удалить комнату",
            "Удалить шкаф", "Очистить библиотеку", "Загрузить библиотеку"};
    String[] TAKE_BOOK_OPTIONS = {"Выберите, откуда взять книгу", "Комната", "Шкаф", "Полка", "Книга"};
    String[] BOOK_FOUND = {"Книга найдена в комнате ", " на шкафу ", " на полке ", " на позиции "};
    String[] FIND_BOOK_OPTIONS = {"Выберите, откуда взять книгу", "Библиотека", "Комната", "Шкаф", "Полка"};
    String TAKE_BOOK_FILTERS = "Выберите, по какому признаку искать книгу";
    String[] PLACE_BOOK_OPTIONS = {"Выберите, куда добавить книгу", "Комната:", "Шкаф:", "Полка:"};
    String ADD_LOADED_BOOK = "Хотите добавить книгу из списка загруженных книг?";
    String CHOOSE_BOOK = "Пожалуйста, выберите книгу";
    String INPUT_AUTHOR = "Введите автора:";
    String INPUT_TITLE = "Введите название книги:";
    String INPUT_YEAR = "Введите год издания:";
    String INPUT_PAGES = "Введите количество страниц:";
    String ADD_BOOK_SUCCESS = "Книга успешно поставлена на полку";
    String[] BOOK_TRAITS = {"Название", "Автор", "Год Издания", "Страницы"};
    String ERR_OUT_OF_RANGE = "Пожалуйста, введите значение между 1 и ";
    String ERR_INCORRECT_VALUE = "Введено неправильное значение";
    String ERR_BOOK_IS_NULL = "На данной позиции нет книги";
    String ERR_BOOK_NOT_FOUND = "Книга не найдена";
    String ERR_GENERIC = "Произошла ошибка";
    String ERR_ROOM_NOT_FOUND = "Данной комнаты не существует";
    String ERR_NO_ROOMS = "В библиотеке нет комнат";
    String ERR_NO_ROOM_OR_BOOKCASE = "Шкаф или комната не существует";
}
