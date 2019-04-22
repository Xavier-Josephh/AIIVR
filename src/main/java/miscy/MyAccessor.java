package miscy;

import java.lang.invoke.CallSite;
import java.lang.invoke.LambdaConversionException;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.function.Function;
import com.baeldung.lambda.apigateway.model.Person;

public final class MyAccessor {
	
	private Function getterFunction;

	public void m1() {
		MethodHandles.Lookup lookup = MethodHandles.lookup();
		CallSite site = null;
		try {
			site = LambdaMetafactory.metafactory(lookup,
					"apply",
					MethodType.methodType(Function.class),
					MethodType.methodType(Object.class, Object.class),
					lookup.findVirtual(Person.class, "getString", MethodType.methodType(String.class)),
					MethodType.methodType(String.class, Person.class));

		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (LambdaConversionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		try {
			getterFunction = (Function) site.getTarget().invokeExact();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Object executeGetter(Object bean) {
		return getterFunction.apply(bean);
	}

	public static void main(String[] args) {
		MyAccessor myAccessor = new MyAccessor();
		myAccessor.m1();
		Object object = myAccessor.getterFunction.apply(new Person());
		System.out.println(object);
	}

}