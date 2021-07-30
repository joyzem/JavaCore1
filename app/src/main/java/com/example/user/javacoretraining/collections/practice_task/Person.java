package com.example.user.javacoretraining.collections.practice_task;

class Person {

    String name;
    String surname;
    String patronymic;
    int birthdayYear;

    public Person(String name, String surname, String patronymic, int birthdayYear) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthdayYear = birthdayYear;
    }

    public int compareTo(Person person) {
        int resultForSurname = changeToPlusMinusOneOrZero(this.surname.compareTo(person.surname));
        if (resultForSurname != 0) {
            return resultForSurname;
        }

        int resultForName = changeToPlusMinusOneOrZero(this.name.compareTo(person.name));
        if (resultForName != 0) {
            return resultForName;
        }

        return changeToPlusMinusOneOrZero(this.patronymic.compareTo(person.patronymic));
    }

    @Override
    public String toString() {
        return "Name: '" + name + '\'' +
                ", surname: '" + surname + '\'' +
                ", patronymic: '" + patronymic + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!name.equals(person.name)) return false;
        if (!surname.equals(person.surname)) return false;
        return patronymic.equals(person.patronymic);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + patronymic.hashCode();
        return result;
    }

    /**
     * Takes value and returns -1 if value is less than 0,
     * 1 if value is greater than 0, else 0
     *
     * @param value Integer
     * @return +- one or zero
     */
    private int changeToPlusMinusOneOrZero(int value) {
        if (value < 0) {
            return -1;
        }
        if (value > 0) {
            return 1;
        }
        return 0;
    }
}
