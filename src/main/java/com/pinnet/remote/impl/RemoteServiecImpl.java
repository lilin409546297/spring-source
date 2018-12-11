package com.pinnet.remote.impl;

import com.pinnet.remote.IRemoteService;

public class RemoteServiecImpl implements IRemoteService {

    public String show() {
        System.out.println("show");
        return "show";
    }
}
