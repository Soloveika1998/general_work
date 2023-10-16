from datetime import date
import os

notes = []
date = date.today()


def add_note(notes, date):  # добавление заметки
    theme = input('Введите тему заметки: ')
    note = input('Введите тело заметки: ')
    record = {"Дата": date, "Тема": theme, "Заметка": note}
    notes.append(record)
    print('Заметка успешно добавлена\n')


def save_notes(notes):  # сохранение записей в файл
    if len(notes) == 0:
        print('записи не добавлены\n')
    else:
        filename = 'notes'
        with open(filename + ".csv", "w", encoding="utf8") as f:
            for note in notes:
                f.write(f"{note['Дата']} {note['Тема']}: {note['Заметка']}\n")
        print('заметки успешно сохранены\n')


def load_notes(notes):  # загрузка записей из файла
    filename = 'notes'
    if not os.path.exists(filename + ".csv"):
        print('Указанный файл не обнаружен\n')
    else:
        with open(filename + ".csv", "r", encoding="utf8") as f:
            for line in f:
                notes_data = line.strip().split(": ")
                date, theme = notes_data[0].split(" ")
                note = notes_data[1]
                record = {"Дата": date, "Тема": theme, "Заметка": note}
                notes.append(record)
        print('заметки загружены\n')


def show_all_notes(notes):  # вывод всех записей в консоль
    if len(notes) == 0:
        print('заметки не добавлены\n')
    else:
        i = 0
        for note in notes:            
            print(
                f"{i}  {note['Дата']} {note['Тема']}: {note['Заметка']}")
            i += 1
        print('\n')


def search_notes(notes):  # поиск заметки по дате
        print("заметки не добавлены\n")
    else:
        search_param = 'Дата'
        search_value = input(
            "Введите дату в формате гггг-мм-дд для поиска например 2023-10-07: ")
        found_notes = []
        for note in notes:
            if note[search_param] == search_value:
                found_notes.append(note)
        if len(found_notes) == 0:
            print("заметки не найдены!\n")
        else:
            for note in found_notes:
                print(f"{note['Дата']} {note['Тема']}: {note['Заметка']}\n")


def edit_note(notes):  # редактирование данных
    date = input('Введите дату редактируюемой заметки: ')
    theme = input('Введите тему заметки для редактирования: ')
    for note in notes:
        if note['Дата'] == date and note['Тема'] == theme:
            note['Дата'] = input('Введите новую дату (гггг-мм-дд): ')
            note['Тема'] = input('Введите новую тему: ')
            note['Заметка'] = input('Ввелите измененную заметку: ')
            print('Спасибо, выбранная заметка изменена\n')
            return
    print('Заметка не найдена\n')
    
def delete_note(notes): # удаление данных
    date = input('Введите дату заметки для удаления: ')
    theme = input('Введите тему заметки для удаления: ')
    for i, note in enumerate(notes):
        if note['Дата'] == date and note['Тема'] == theme:
            del notes[i]
            print('Заметка удалена')
            return
    print('Заметка не обнаружена')
    
def delete_note_by_index(notes): # удаление данных по индексу
    flag = True
    while flag:
        try:
            index = int(input('Введите индекс удаляемой заметки: '))
            flag = False
        except ValueError:
            print('Необходимо ввести число')
    
    if index < len(notes):
        del notes[index]
        print('Заметка удалена')
    else:
        print('Заметка с таким индексом не обнаружена')