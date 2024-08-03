package com.crud.rpc_api.api;

import com.crud.rpc_api.model.Laptop;
import com.googlecode.jsonrpc4j.JsonRpcMethod;
import com.googlecode.jsonrpc4j.JsonRpcParam;
import com.googlecode.jsonrpc4j.JsonRpcService;

import java.util.List;

@JsonRpcService("/rpc")
public interface LaptopServerApi {

    @JsonRpcMethod("laptop.all")
    List<Laptop> getAllLaptops();

    @JsonRpcMethod("laptop.get")
    Laptop getLaptopById(@JsonRpcParam(value = "id") Long id);

    @JsonRpcMethod("laptop.create")
    Laptop createLaptop(@JsonRpcParam(value = "laptop") Laptop laptop);

    @JsonRpcMethod("laptop.update")
    Laptop updateLaptop(@JsonRpcParam(value = "laptop") Laptop laptop);

    @JsonRpcMethod("laptop.delete")
    String deleteLaptop(@JsonRpcParam(value = "id") Long id);
}