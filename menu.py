import os
from methods import *

notes = []

load_notes(notes)

while True:
    print("1. Добавить заметку")
    print("2. Показать все заметки")
    print("3. Сохранить записанные заметки в файл")
    print("4. Загрузить сохраненные заметки из файла")
    print("4. Поиск заметки по дате")
    print("5. Редактировать заметку")
    print("6. Удалить заметку")
    print("7. Удаление заметки по индексу")
    print("8. Выход")

    choice = input("Выберите действие: ")
    if choice == "1":
        add_note(notes, date)
    elif choice == "2":
        show_all_notes(notes)
    elif choice == "3":
        save_notes(notes)
    elif choice == "4":
        search_notes(notes)
    elif choice == "5":
        edit_note(notes)
    elif choice == "6":
        delete_note(notes)
    elif choice == "7":
        delete_note_by_index(notes)
    elif choice == "8":
        save_notes(notes)
        print('Спасибо, возвращайтесь ещё.')
        break
    else:
        print("Неверный выбор!")