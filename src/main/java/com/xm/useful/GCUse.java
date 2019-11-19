package com.xm.useful;

public class GCUse {

    public static GCUse SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("yes,i am still alive !!");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("where call this method.");
        System.out.println("finalize method executed!");
        GCUse.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Exception {
        SAVE_HOOK = new GCUse();
        //对象第一次拯救自己
        SAVE_HOOK= null;
        System.gc();
        //因为finalize方法优先级很低，所有暂停一会，等待它执行
        Thread.sleep(1500);
        System.out.println("run in here.");
        if(SAVE_HOOK!=null ) {
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("no, i am dead");
        }
        //下面代码跟上面完全相同，拯救失败
        SAVE_HOOK= null;
        System.gc();
        //因为finalize方法优先级很低，所有暂停一会，等待它执行
        Thread.sleep(500);
        if(SAVE_HOOK!=null ) {
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("no, i am dead");
        }

    }


}
