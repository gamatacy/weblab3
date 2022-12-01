package database

import beans.ResultBean

class ResultsDao {
    companion object{
        fun getById(id: Int): ResultBean?{
            val session = HibernateSessionFactory.getSessionFactory()?.openSession()
            session?.beginTransaction()
            val resultBean = session?.get(ResultBean::class.java, id)
            session?.transaction?.commit()
            return resultBean
        }

        fun add(resultBean: ResultBean){
            val session = HibernateSessionFactory.getSessionFactory()?.openSession()
            session?.beginTransaction()
            session?.save(resultBean)
            session?.transaction?.commit()
        }

        fun getResults(){
            val session = HibernateSessionFactory.getSessionFactory()?.openSession()
            if (session != null) {
                session.beginTransaction()
                val count = session.createQuery("SELECT COUNT(*) FROM beans.ResultBean")
                println("/// COUNT ///")
                println(count.resultList.toString())
                println("/// COUNT ///")
                session.transaction.commit()
                session.close()
            }
        }

    }
}