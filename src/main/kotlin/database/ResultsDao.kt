package database

import beans.ResultBean

class ResultsDao {
    companion object {

        fun add(resultBean: ResultBean) {
            val session = HibernateSessionFactory.getSessionFactory()?.openSession()
            session?.beginTransaction()
            session?.save(resultBean)
            session?.transaction?.commit()
        }

        fun getResults(): MutableList<Any?> {
            val session = HibernateSessionFactory.getSessionFactory()?.openSession()
            if (session != null) {
                session.beginTransaction()
                val query = session.createQuery("from beans.ResultBean")
                val list = query.list()
                session.transaction.commit()
                session.close()
                return list
            }
            return mutableListOf()
        }

    }
}