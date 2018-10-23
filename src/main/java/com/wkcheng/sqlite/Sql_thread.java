package com.wkcheng.sqlite;

import com.almworks.sqlite4java.*;

import java.util.concurrent.ExecutionException;

/**
 * @author created by wkcheng@iflytek.com at 2018/7/30 18:28
 * @desc
 */
public class Sql_thread implements Runnable {
    private SQLiteQueue myQueue;

    public Sql_thread(SQLiteQueue myQueue) {
        this.myQueue = myQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            //  本地有查询方法就不用传入myQueue，否则参数里需要带上myQueue直到传递到sqlite操作方法里
            insert_Record(Thread.currentThread().getId() + "-" + i, "插入" + i);
        }
//        try {
//            System.out.println(search());
//        } catch (ExecutionException | InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    //********************************写数据库**************************************************************
    private Boolean insert_Record(final String cardno, final String card_type) {
        return myQueue.execute(new SQLiteJob<Boolean>() {
            protected Boolean job(SQLiteConnection connection) throws SQLiteException {
                SQLiteStatement st = connection.prepare("insert into record(cardno,card_type) values (?,?)");
                try {
                    st.bind(1, cardno);
                    st.bind(2, card_type);
                    st.step();
                    return true;
                } finally {
                    st.dispose();
                }
            }
        }).complete();
    }

    private TransferBase search() throws ExecutionException, InterruptedException {
        return myQueue.execute(new SQLiteJob<TransferBase>() {
            @Override
            protected TransferBase job(SQLiteConnection sqLiteConnection) throws Throwable {
                SQLiteStatement st = sqLiteConnection.prepare("select * from transfer_base where transfer_id = '16b98054b6149269'");
                try {
                    st.step();
//                    while (st.step()) {
//                        String title = st.columnString(2);
//                        System.out.println(title);
//                    }
                    return null;
                } finally {
                    st.dispose();
                }
            }
        }).complete();
    }
}
