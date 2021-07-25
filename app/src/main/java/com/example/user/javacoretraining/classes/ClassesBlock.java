package com.example.user.javacoretraining.classes;


import static java.lang.Math.random;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;


/**
 * Набор заданий по работе с классами в java.
 * <p>
 * Задания подразумевают создание класса(ов), выполняющих задачу.
 * <p>
 * Проверка осуществляется ментором.
 */
public class ClassesBlock {

    /*
      I

      Создать класс с двумя переменными. Добавить функцию вывода на экран
      и функцию изменения этих переменных. Добавить функцию, которая находит
      сумму значений этих переменных, и функцию, которая находит наибольшее
      значение из этих двух переменных.
     */

    class FirstTask {

        int firstVar = 10;
        int secondVar = 20;

        public void displayFields() {
            System.out.printf("First var: %d\nSecond var: %d", firstVar, secondVar);
        }

        public void setFirstVar(int firstVar) {
            this.firstVar = firstVar;
        }

        public void setSecondVar(int secondVar) {
            this.secondVar = secondVar;
        }

        public int getSum() {
            return firstVar + secondVar;
        }

        public int getMax() {
            return (firstVar > secondVar) ? firstVar : secondVar;
        }
    }

    /*
      II

      Создать класс, содержащий динамический массив и количество элементов в нем.
      Добавить конструктор, который выделяет память под заданное количество элементов.
      Добавить методы, позволяющие заполнять массив случайными числами,
      переставлять в данном массиве элементы в случайном порядке, находить количество
      различных элементов в массиве, выводить массив на экран.
     */

    class SecondTask {

        private final ArrayList<Integer> arrayList;
        private int arraySize = 0;

        SecondTask(int size) {
            arrayList = new ArrayList<>(size);
        }

        public void fillWithRandomNumbers(int amount, int from, int to) {
            arraySize += amount;
            for (int i = 0; i < amount; i++) {
                arrayList.add(from + (int) (random() * to));
            }
        }

        public void shuffleArray() {

            for (int i = 0; i < arraySize; i++) {

                int firstIndex = (int) (random() * (arraySize - 1));
                int secondIndex = (int) (random() * (arraySize - 1));

                int temp = arrayList.get(firstIndex);
                arrayList.set(firstIndex, arrayList.get(secondIndex));
                arrayList.set(secondIndex, temp);
            }
        }

        public int findUnique() {

            return new TreeSet<Integer>(arrayList).size();
        }

        public void displayArray() {

            for (int elem : arrayList) {
                System.out.println(elem);
            }
        }
    }

    /*
      III

      Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов,
      вычисления площади, периметра и точки пересечения медиан.
      Описать свойства для получения состояния объекта.
     */

    abstract class AbstractTriangle {

        float x1;
        float y1;
        float x2;
        float y2;
        float x3;
        float y3;

        AbstractTriangle(float x1, float y1, float x2,
                         float y2, float x3, float y3) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.x3 = x3;
            this.y3 = y3;
        }

        abstract float calculateArea();
        abstract float calculatePerimeter();
        abstract float findMeridiansOverlapPoint();

    }

    /*
      IV

      Составить описание класса для представления времени.
      Предусмотреть возможности установки времени и изменения его отдельных полей
      (час, минута, секунда) с проверкой допустимости вводимых значений.
      В случае недопустимых значений полей выбрасываются исключения.
      Создать методы изменения времени на заданное количество часов, минут и секунд.
     */

    abstract class AbsctractTime {

        protected Hours hours = new Hours(0);
        protected Minutes minutes = new Minutes(0, hours);
        protected Seconds seconds = new Seconds(0, minutes);

        AbsctractTime(int h, int min, int sec) {

            try {
                setTime(h, min, sec);
            } catch (IllegalArgumentException e) {
                System.out.println("Wrong input!");
            }
        }

        public void setTime(int h, int min, int sec) throws IllegalArgumentException {
            if (hours.isTimeValid(h) && minutes.isTimeValid(min) && seconds.isTimeValid(sec)) {
                hours.setTime(h);
                minutes.setTime(min);
                seconds.setTime(sec);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public void setHours(int h) throws IllegalArgumentException {
            if (hours.isTimeValid(h)) {
                hours.setTime(h);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public void setMinutes(int min) throws IllegalArgumentException {
            if (minutes.isTimeValid(min)) {
                minutes.setTime(min);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public void setSeconds(int sec) throws IllegalArgumentException {
            if (seconds.isTimeValid(sec)) {
                seconds.setTime(sec);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public void moveHoursForward(int h) {
            hours.moveTimeForward(h);
        }

        public void moveMinutesForward(int m) {
            minutes.moveTimeForward(m);
        }

        public void moveSecondsForward(int s) {
            seconds.moveTimeForward(s);
        }

        abstract class TimePresenter {

            protected int time;
            protected int maxValue;
            protected TimePresenter highLevelPresenter;

            TimePresenter(int t, TimePresenter highLevelPres) {
                time = t;
                highLevelPresenter = highLevelPres;
            }

            // For Hours presenter
            TimePresenter(int t){
                time = t;
                highLevelPresenter = null;
            }

            public boolean isTimeValid(int givenTime) {
                return givenTime <= maxValue && givenTime >= 0;
            }

            public void setTime(int givenTime) {
                time = givenTime;
            }

            public void moveTimeForward(int deltaTime) {

                int timeSum = time + deltaTime;
                time = timeSum % (maxValue + 1);

                if (timeSum > maxValue) {
                    int highLevelChange = timeSum / (maxValue + 1);
                    highLevelPresenter.moveTimeForward(highLevelChange);
                }
            }

            public int getTime() {
                return time;
            }

        }

        class Hours extends TimePresenter {

            Hours(int h) {
                super(h);
                maxValue = 23;
            }

            @Override
            public void moveTimeForward(int deltaTime) {
                time = (time + deltaTime) % (maxValue + 1);
            }
        }

        class Minutes extends TimePresenter {

            Minutes(int m, TimePresenter highLevelPres) {
                super(m, highLevelPres);
                maxValue = 59;
            }
        }

        class Seconds extends TimePresenter {

            Seconds(int s, TimePresenter highLevelPres) {
                super(s, highLevelPres);
                maxValue = 59;
            }
        }
    }

    /*
      V

      Класс Абонент: Идентификационный номер, Фамилия, Имя, Отчество, Адрес,
      Номер кредитной карточки, Дебет, Кредит, Время междугородных и городских переговоров;
      Конструктор; Методы: установка значений атрибутов, получение значений атрибутов,
      вывод информации. Создать массив объектов данного класса.
      Вывести сведения относительно абонентов, у которых время городских переговоров
      превышает заданное.  Сведения относительно абонентов, которые пользовались
      междугородной связью. Список абонентов в алфавитном порядке.
     */

    class ClientsDatabase {

        ArrayList<Client> database = new ArrayList<>();

        public void addClient(String name, String surname, String patronymic,
                              String address, String creditCardNumber) {
            Client client = new Client(name, surname, patronymic,
                    address, creditCardNumber);
            database.add(client);
        }

        public void displayClientsWithCityTimeMoreThanGiven(int seconds) {

            System.out.printf("\nClients with a city calls time more than %d:\n", seconds);

            for (Client client : database) {
                if (client.inCityCallsTime.getTimeInSeconds() > seconds) {
                    client.displayInfo();
                }
            }
        }

        public void displayClientsThatHaveUsedLongCalls() {


            System.out.println("\nClients that have used long calls");

            for (Client client : database) {
                if (client.longDistanceCallsTime.getTimeInSeconds() > 0) {
                    client.displayInfo();
                }
            }
        }

        public void sortDatabase() {
            for (int i = 0; i < database.size(); i++) {
                for (int j = i + 1; j < database.size(); j++) {
                    if (database.get(i).compareTo(database.get(j)) > 0) {
                        Client temp = database.get(i);
                        database.set(i, database.get(j));
                        database.set(j, temp);
                    }
                }
            }
        }

        private int getMaxId() {
            return database.size();
        }

        class Client extends Person {

            private final int id;
            private String creditCardNumber;
            private BigDecimal debit;
            private BigDecimal credit;
            private CallsTime longDistanceCallsTime = new CallsTime(0, 0, 0);
            private CallsTime inCityCallsTime = new CallsTime(0, 0, 0);


            Client(String name, String surname, String patronymic,
                   String address, String creditCardNumber) {

                super(name, surname, patronymic, address);
                this.creditCardNumber = creditCardNumber;
                id = ClientsDatabase.this.getMaxId() + 1;
                debit = BigDecimal.ZERO;
                credit = BigDecimal.ZERO;
            }

            public void displayInfo() {

                System.out.println("Client's info:\n");
                super.displayInfo();

                System.out.printf("Credit card number: %s\n" + "Debit: %.2f\n" +
                                "Credit: %.2f\n" + "Long distance calls' time: %d\n" +
                                "In city calls' time: %d\n",
                        creditCardNumber, debit, credit,
                        longDistanceCallsTime.getTimeInSeconds(),
                        inCityCallsTime.getTimeInSeconds());
            }

            public int getId() {
                return id;
            }

            public String getCreditCardNumber() {
                return creditCardNumber;
            }

            public void setCreditCardNumber(String creditCardNumber) {
                this.creditCardNumber = creditCardNumber;
            }

            public BigDecimal getDebit() {
                return debit;
            }

            public void setDebit(BigDecimal debit) {
                this.debit = debit;
            }

            public BigDecimal getCredit() {
                return credit;
            }

            public void setCredit(BigDecimal credit) {
                this.credit = credit;
            }

            public void setLongDistanceCallsTime(int h, int m, int s) {
                longDistanceCallsTime.setTime(h, m, s);
            }

            public void moveLongDistanceCallsTime(int s) {
                longDistanceCallsTime.moveSecondsForward(s);
            }

            public void setInCityCallsTime(int h, int m, int s) {
                inCityCallsTime.setTime(h, m, s);
            }

            public void moveInCityCallsTime(int s) {
                inCityCallsTime.moveSecondsForward(s);
            }
        }
    }

    abstract class Person implements Comparable<Person> {

        protected String name;
        protected String surname;
        protected String patronymic;
        protected String address;

        Person(String name, String surname, String patronymic, String address) {

            this.name = name;
            this.surname = surname;
            this.patronymic = patronymic;
            this.address = address;
        }

        public void displayInfo() {
            System.out.printf( "Name: %s\n" + "Surname: %s\n" + "Patronymic: %s\n" +
                    "Address: %s\n", name, surname, patronymic, address);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getPatronymic() {
            return patronymic;
        }

        public void setPatronymic(String patronymic) {
            this.patronymic = patronymic;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        @Override
        public int compareTo(Person person) {
            int result = this.surname.compareTo(person.getSurname());
            if (result == 0) {
                return this.name.compareTo(person.getName());
            } else {
                return result;
            }
        }

    }

    class CallsTime extends AbsctractTime {

        CallsTime(int h, int min, int sec) {
            super(h, min, sec);
        }

        public int getTimeInSeconds() {
            return hours.getTime() * 60 * 60 + minutes.getTime() * 60 + seconds.getTime();
        }
    }

    /*
      VI

      Задача на взаимодействие между классами. Разработать систему «Вступительные экзамены».
      Абитуриент регистрируется на Факультет, сдает Экзамены. Преподаватель выставляет Оценку.
      Система подсчитывает средний бал и определяет Абитуриента, зачисленного в учебное заведение.
     */

    class Applicant {

        private String name;
        private String surname;
        private final HashMap<Exam, Integer> examsGradeMap = new HashMap<>();

        Applicant(String n, String s) {
            name = n;
            surname = s;
        }

        public HashMap<Exam, Integer> getExamsGradeMap() {
            return examsGradeMap;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        public void enrollToFaculty(ExamsSystem examsSystem) {

            examsSystem.displayInfo();

            System.out.print("Choose the faculty: ");
            int choice = new Scanner(System.in).nextInt();

            ArrayList<Exam> examsList;
            try {
                examsList = examsSystem.getFacultyExams(choice - 1);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Incorrect Choice");
                return;
            }

            for (Exam exam: examsList) {
                examsGradeMap.put(exam, 0);
            }

            examsSystem.enrollNewApplicant(this, choice - 1);
        }

        public void passExams(ExamsSystem examsSystem) {

            for (Map.Entry<Exam, Integer> examGradeEntry : examsGradeMap.entrySet()) {
                try {

                    examsGradeMap.put(examGradeEntry.getKey(),
                            examsSystem.examApplicant(examGradeEntry.getKey()));

                    System.out.printf("Exam: %s, grade: %d\n",
                            examGradeEntry.getKey().getName(),
                            examGradeEntry.getValue());

                } catch (IllegalArgumentException e) {
                    System.out.printf("There is no teachers that can the exam: %s\n",
                            examGradeEntry.getKey().getName());
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Applicant applicant = (Applicant) o;

            if (!name.equals(applicant.name)) return false;
            return surname.equals(applicant.surname);
        }

        @Override
        public int hashCode() {
            int result = name.hashCode();
            result = 31 * result + surname.hashCode();
            return result;
        }
    }


    class Faculty {

        private final String facultyName;
        private final ArrayList<Exam> examsArray;

        Faculty(String name, Exam[] examsArray) {
            facultyName = name;
            this.examsArray = new ArrayList<>(Arrays.asList(examsArray));
        }

        public String getName() {
            return facultyName;
        }

        public ArrayList<Exam> getExams() {
            return examsArray;
        }
    }


    class ExamsSystem {

        private final ArrayList<Faculty> faculties;
        private final HashMap<Applicant, Faculty> allApplicants = new HashMap<>();
        private final ArrayList<Teacher> teachers;
        private final float minAverageGrade;

        ExamsSystem(Faculty[] faculties, Teacher[] teachers, float minAverage) {

            this.faculties = new ArrayList<>(Arrays.asList(faculties));
            this.teachers = new ArrayList<>(Arrays.asList(teachers));
            minAverageGrade = minAverage;
        }

        public void displayInfo() {

            int counter = 1;
            for (Faculty faculty : faculties) {
                System.out.printf("%d: Faculty: %s\n", counter, faculty.getName());
                System.out.println("Exams: ");
                for (Exam exam: faculty.getExams()) {
                    System.out.println(exam.getName());
                }
                counter++;
            }
        }

        public void enrollNewApplicant(Applicant applicant, int facultyIndex) {
            allApplicants.put(applicant, faculties.get(facultyIndex));
        }

        public ArrayList<Exam> getFacultyExams(int facultyIndex) {
            return faculties.get(facultyIndex).getExams();
        }

        public Integer examApplicant(Exam exam) throws IllegalArgumentException {
            for (Teacher teacher : teachers) {
                if (teacher.hasExam(exam)) {
                    return teacher.getMark();
                }
            }
            throw new IllegalArgumentException();
        }

        public ArrayList<Applicant> getAdmittedApplicants() {

            ArrayList<Applicant> admittedApplicants = new ArrayList<>();

            for (Map.Entry<Applicant, Faculty> applicantEntry : allApplicants.entrySet()) {

                float applicantAverage = getAverageOfApplicant(applicantEntry.getKey());

                if (applicantAverage >= minAverageGrade) {
                    admittedApplicants.add(applicantEntry.getKey());
                }
            }

            return admittedApplicants;
        }

        private float getAverageOfApplicant(Applicant applicant) {

            int sum = 0;
            HashMap<Exam, Integer> examGradeMap = applicant.getExamsGradeMap();

            for (Map.Entry<Exam, Integer> exam : examGradeMap.entrySet()) {
                try {
                    sum += exam.getValue();
                } catch (NullPointerException e) {                // When there is no teachers
                    sum += 0;
                }
            }

            return (float) sum / examGradeMap.size();
        }
    }

    class Teacher {

        String name;
        ArrayList<Exam> examsDisciplines;

        Teacher(String name, Exam[] examsDisciplines) {
            this.name = name;
            this.examsDisciplines = new ArrayList<>(Arrays.asList(examsDisciplines));
        }

        public boolean hasExam(Exam exam) {
            return examsDisciplines.contains(exam);
        }

        public int getMark() {
            return 4;
        }
    }

    class Exam {

        private final String name;

        Exam(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Exam exam = (Exam) o;

            return name.equals(exam.name);
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }
    }

    class TeachersDatabase {

        public Teacher[] getTeachers() {

            Teacher[] teachers = new Teacher[] {
                    new Teacher("Tkachencko",
                            new Exam[] {new Exam("Biology"), new Exam("English language")}
                    )
            };
            return teachers;
        }
    }

    /*
      VII

      Задача на взаимодействие между классами. Разработать систему «Интернет-магазин».
      Товаровед добавляет информацию о Товаре. Клиент делает и оплачивает Заказ на Товары.
      Товаровед регистрирует Продажу и может занести неплательщика в «черный список».
     */

    abstract class SimplePerson {

        String name;
        String surname;

        SimplePerson(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            SimplePerson person = (SimplePerson) o;

            if (!name.equals(person.name)) return false;
            return surname.equals(person.surname);
        }

        @Override
        public int hashCode() {
            int result = name.hashCode();
            result = 31 * result + surname.hashCode();
            return result;
        }
    }

    abstract class Product {

        protected long id;
        protected BigDecimal cost;
        protected String name;

        Product(long id, BigDecimal cost, String name) {
            this.id = id;
            this.cost = cost;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public BigDecimal getCost() {
            return cost;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Product product = (Product) o;

            if (id != product.id) return false;
            if (!cost.equals(product.cost)) return false;
            return name.equals(product.name);
        }

        @Override
        public int hashCode() {
            int result = (int) (id ^ (id >>> 32));
            result = 31 * result + cost.hashCode();
            result = 31 * result + name.hashCode();
            return result;
        }

    }

    class Client extends SimplePerson {

        private ArrayList<Product> boughtItems = new ArrayList<>();
        private BigDecimal balance;

        Client(String name, String surname, BigDecimal balance) {
            super(name, surname);
            this.balance = balance;
        }

        public void addItem(Product product) {
            boughtItems.add(product);
        }

        public BigDecimal getBalance() {
            return balance;
        }

        public boolean makeOrder(InternetShop shop) {

            shop.showProducts();

            System.out.print("Choose the product: ");
            int choice = new Scanner(System.in).nextInt();

            Product product;

            try {
                product = shop.getProductById(choice - 1);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Wrong input.\n");
                return false;
            }

            try {

                Order order = new Order(product, this);
                shop.productManager.recordSale(order);
                addItem(product);
                balance.subtract(product.getCost());
                return true;

            } catch (NotEnoughMoneyException e) {

                System.out.printf("Your balance: %.2f\nThe price: %.2f", e.balance, e.required);
                return false;

            } catch (InBlackListException e) {

                System.out.println(e.getMessage());
                return false;
            }
        }
    }

    class Order {

        Product product;
        SimplePerson owner;

        Order(Product product, Client owner) throws NotEnoughMoneyException {

            if (product.getCost().compareTo(owner.getBalance()) > 0) {
                throw new NotEnoughMoneyException(
                        owner.getBalance(), product.getCost());
            }
            this.product = product;
            this.owner = owner;
        }

        public Product getProduct() {
            return product;
        }

        public SimplePerson getOwner() {
            return owner;
        }
    }

    class InternetShop {

        private LinkedList<Product> products;
        private ArrayList<SimplePerson> blackList = new ArrayList<>();
        private HashMap<Product, SimplePerson> soldProducts = new HashMap<>();
        ProductManager productManager;

        InternetShop(ProductManager productManager, Product[] products) {
            this.productManager = productManager;
            this.products = new LinkedList<>(Arrays.asList(products));
        }

        public void showProducts() {

            int count = 1;

            System.out.println("Shop's products:");
            for (Product product : products) {
                System.out.printf("%d: %s\n", count, product.getName());
                count++;
            }
        }

        public Product getProductById(int id) throws IndexOutOfBoundsException {
            return products.get(id);
        }

        class ProductManager extends SimplePerson {

            ProductManager(String name, String surname) {
                super(name, surname);
            }

            public void addProduct(Product product) {
                InternetShop.this.products.add(product);
            }

            public void addToBlackList(SimplePerson person) {
                blackList.add(person);
            }

            public void recordSale(Order order) throws InBlackListException {
                if (!blackList.contains(order.getOwner())) {

                    Product product = order.getProduct();
                    products.remove(product);
                    soldProducts.put(product, order.getOwner());

                } else {
                    throw new InBlackListException("The customer in the blacklist.\n");
                }
            }

        }
    }

    class NotEnoughMoneyException extends Exception {

        BigDecimal balance;
        BigDecimal required;

        NotEnoughMoneyException(BigDecimal balance, BigDecimal required) {
            this.balance = balance;
            this.required = required;
        }
    }

    class InBlackListException extends Exception {

        InBlackListException(String message) {
            super(message);
        }

    }
}
