package com.walking.jpa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateApplication {
//    Для лаконичности в примере опущена работа с closeable-ресурсами
    public static void main(String[] args) {
//        Создаем объект конфигурации и динамически загружаем hibernate.cfg.xml
        Configuration configuration = new Configuration()
                .configure();

//        На основе загруженной конфигурации создаем SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

//        Открываем сессию - высокоуровневую надстройку над транзакцией на уровне БД.
//        Этот интерфейс отвечает за наиболее значимую логику ORM.
        Session session = sessionFactory.openSession();

//        Получаем объект транзакции. Отражение реальной транзакции на уровне БД в Hibernate.
        Transaction transaction = session.getTransaction();

//        Открытие транзакции
        transaction.begin();
//        Коммит транзакции
        transaction.commit();
    }
}
