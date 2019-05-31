package com.hcb.netty.thrift;


import com.hcb.thrift.generated.DataException;
import com.hcb.thrift.generated.Person;
import com.hcb.thrift.generated.PersonService;
import org.apache.thrift.TException;


/**
 *这个实现代码是位于服务端的. 能被客户端远程调用,实现rpc的功能.
 */
public class PersonServiceImpl implements PersonService.Iface {
    @Override
    public Person getPersonByUsername(String username) throws DataException, TException {
        System.out.println("Got Client Param: " + username);

        Person person = new Person();

        person.setUsername(username);
        person.setAge(20);
        person.setMarried(false);

        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        System.out.println("Got Client Param: ");

        System.out.println(person.getUsername());
        System.out.println(person.getAge());
        System.out.println(person.isMarried());
    }
}
