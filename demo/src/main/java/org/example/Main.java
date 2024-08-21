package org.example;

import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.code.DataType;
import com.serotonin.modbus4j.exception.ErrorResponseException;
import com.serotonin.modbus4j.exception.ModbusInitException;
import com.serotonin.modbus4j.exception.ModbusTransportException;

public class Main {
    public static void main(String[] args) throws ModbusInitException, ModbusTransportException, ErrorResponseException {
        System.out.println("Hello world!");

        ModbusMaster master = ModbusTcpMaster.getMaster("127.0.0.1", 502);

        System.out.println(Modbus4jReadUtils.readCoilStatus(master, 1, 0, 1)[0]);
        System.out.println(Modbus4jReadUtils.readCoilStatus(master, 1, 1, 1)[0]);
        System.out.println(Modbus4jReadUtils.readCoilStatus(master, 1, 2, 1)[0]);

        Modbus4jWriteUtils.writeCoils(master, 1, 0, new boolean[]{true});

        System.out.println(Modbus4jReadUtils.readCoilStatus(master, 1, 0, 1)[0]);


    }
}