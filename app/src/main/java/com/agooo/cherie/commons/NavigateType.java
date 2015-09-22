package com.agooo.cherie.commons;

/**
 * author cherie
 * date 2015/9/20
 * */
public enum NavigateType {

    // 主页
    HOME {
        @Override
        public int getValue() {
            return 0;
        }
    };

    public abstract int getValue();
}
