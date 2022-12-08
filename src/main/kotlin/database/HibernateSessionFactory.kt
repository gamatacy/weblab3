package database

import beans.ResultBean
import org.hibernate.SessionFactory
import org.hibernate.cfg.Configuration

object HibernateSessionFactory {
    private var sessionFactory: SessionFactory? = null

    fun getSessionFactory(): SessionFactory? {
        if (sessionFactory == null) {
            try {
                var configuration = Configuration()
                configuration.configure()
                configuration.addAnnotatedClass(ResultBean::class.java)
                sessionFactory = configuration.buildSessionFactory()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return sessionFactory
    }

}