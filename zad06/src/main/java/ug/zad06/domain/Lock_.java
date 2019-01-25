package ug.zad06.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Lock.class)
public class Lock_ {
    public static volatile SingularAttribute<Lock, Producer> producer;
    public static volatile SingularAttribute<Lock, Boolean> electronic;
}
