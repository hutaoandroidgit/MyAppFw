package com.hutao.myappfw.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import androidx.annotation.Nullable;

import com.hutao.myappfw.IMyAidlInterface;
import com.hutao.myappfw.Studentinfo;

/**
 * @ProjectName: MyAppFw
 * @Package: com.hutao.myappfw.service
 * @ClassName: MyService
 * @Description: 类作用描述
 * @Author: hutao
 * @CreateDate: 2021/11/1 10:58
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/11/1 10:58
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class MyService extends Service {
    public MyService() {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    private class MyBinder extends IMyAidlInterface.Stub {
        @Override
        public String getName() throws RemoteException {
            return "test";
        }

        @Override
        public Studentinfo getStudentinfo() throws RemoteException {
            return new Studentinfo("hutao");
        }
    }
}