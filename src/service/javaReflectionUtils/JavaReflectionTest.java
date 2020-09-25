package service.javaReflectionUtils;

import service.others.PersonModel;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JavaReflectionTest {
    public static void main(String args[]) {
     PersonModel model = new PersonModel();
     setModelUsingReflection(model);
        System.out.println("setModelUsingReflection Person model : "+model.toString());
     PersonModel toUpdateModel = getNewPersonModel();
        System.out.println("getNewPersonModelUsingReflection Person model "+toUpdateModel.toString());
     updateNameUsingReflection(model,"Bhavesh Popli");
        System.out.println("updateNameUsingReflection Person model : "+model.toString());
     updateModelUsingReflection(model,toUpdateModel);
        System.out.println("updateModelUsingReflection Person model : "+model.toString());

    }

    private static void updateModelUsingReflection(PersonModel model, PersonModel toUpdateModel) {
        if(null != toUpdateModel && null != model) {
            for(Field field : toUpdateModel.getClass().getDeclaredFields()) {
                if(null != field) {
                    PropertyDescriptor pd1 = null;
                    PropertyDescriptor pd2 = null;
                    try {
                        pd1 = new PropertyDescriptor(field.getName(), toUpdateModel.getClass());
                        pd2 = new PropertyDescriptor(field.getName(), model.getClass());
                        Method getter = pd1.getReadMethod();
                        Method setter = pd2.getWriteMethod();
                        try {
                            String val = (String) getter.invoke(toUpdateModel);
                            System.out.println("Field name : "+field.getName() +" Value : "+val);
                            if(null != val) {
                                setter.invoke(model,val);
                            }
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    } catch (IntrospectionException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }

    private static PersonModel getNewPersonModel() {
        System.out.println("---getNewPersonModelUsingReflection---");
        PersonModel model = null;
        try {
            Constructor constructor = PersonModel.class.getConstructor(String.class,String.class,String.class);
            try {
                model = (PersonModel) constructor.newInstance("Jaya",null,"myaccount");
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        //printAllConstructors();
        return model;
    }

    private static void printAllConstructors() {
        Constructor[] constructors = PersonModel.class.getConstructors();
        if(null != constructors) {
            for (int i = 0; i < constructors.length; i++) {
                System.out.println("constuctor: " + constructors[i]);

            }
        }
    }

    private static void updateNameUsingReflection(PersonModel model, String newName) {
        System.out.println("---updateNameUsingReflection---");
        Method[] declaredMethods = model.getClass().getDeclaredMethods();
        if(null !=declaredMethods) {
            System.out.println("########## Methods ##########");
            for(Method method : declaredMethods) {
                if(null != method) {
                    //System.out.println("Method name : "+method.getName());
                    switch (method.getName()) {
                        case "updateName" :
                            try {
                                method.invoke(model,newName);
                            }
                            catch (Exception e) {
                                e.printStackTrace();
                                System.out.println("Exception updateNameUsingReflection " + e.toString());
                            }
                    }
                }
            }
        }
    }

    private static void setModelUsingReflection(PersonModel model) {
        System.out.println("---setModelUsingReflection---");
        Field[] declaredFields = model.getClass().getDeclaredFields();
        if(null != declaredFields) {
            System.out.println("########## Fields ##########");
            for(Field field : declaredFields) {
                if(null != field) {
                    System.out.println("Field name : "+field.getName());
                    try {
                        PropertyDescriptor pd1 = new PropertyDescriptor(field.getName(), model.getClass());
                        Method set = pd1.getWriteMethod();
                        switch (field.getName()) {
                            case "name" :
                                set.invoke(model,"Bhavesh");
                                break;
                            case "age" :
                                set.invoke(model,"24");
                                break;
                            case "applicationId" :
                                set.invoke(model,"DUAPP");
                                break;

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Exception setModelUsingReflection " + e.toString());
                    }
                }
            }
        }

    }
}
