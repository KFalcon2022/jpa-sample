package com.walking.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaApplication {
//    Для лаконичности в примере опущена работа с closeable-ресурсами
    public static void main(String[] args) {
//        Динамически загружаем persistence.xml,
//        по значению параметра (persistenceUnitName) определяем, кто выступает в роли PersistenceProvider
//        и создаем EntityManagerFactory через реализацию в этом PersistenceProvider.
//        В данном случае будет создан объект SessionFactoryImpl - основной реализации SessionFactory из Hibernate
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hibernate");

//        Получаем объект EntityManager. Именно этот объект контролирует взаимодействие
//        с реальной транзакцией на уровне БД и реализует наиболее значимую логику ORM.
//        В данном случае будет создан объект SessionImpl - основной реализации Session из Hibernate
        EntityManager em = emf.createEntityManager();

//        Получаем объект транзакции. Отражение реальной транзакции на уровне БД в JPA.
//        Простой интерфейс, понятный даже сейчас - открытие, коммит и откат транзакции.
//        Подобный API нам знаком еще по JDBC. Есть небольшие дополнения, но о них позже
        EntityTransaction transaction = em.getTransaction();

//        Открытие транзакции
        transaction.begin();
//        Коммит транзакции
        transaction.commit();
    }
}
