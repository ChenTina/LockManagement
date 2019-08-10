package com.bed_lock.utils;


import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
    //�������������ļ���KEY����һֱ
    private String[] encryptPropNames = {"jdbc.username", "jdbc.password"};

    @Override
    protected String convertProperty(String propertyName, String propertyValue) {

        //����ڼ������������з��ָ�����  
        if (isEncryptProp(propertyName)) {
            String decryptValue = DESUtil.getDecryptString(propertyValue);
            System.out.println(decryptValue);
            return decryptValue;
        } else {
            return propertyValue;
        }

    }

    private boolean isEncryptProp(String propertyName) {
        for (String encryptName : encryptPropNames) {
            if (encryptName.equals(propertyName)) {
                return true;
            }
        }
        return false;
    }
} 
