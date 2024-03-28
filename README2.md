Implementing a custom context holder involves several best practices to ensure that it functions correctly and efficiently. Here are some of them:

1. **Thread Safety**: The context holder should be thread-safe since it will be accessed by multiple threads simultaneously. This can be achieved by using `ThreadLocal` variables in Java.

2. **Clearing Context**: Always clear the context at the end of the request to prevent memory leaks and incorrect data being available in the next request.

3. **Immutable Context Data**: The data stored in the context should be immutable to prevent any accidental modifications once it's set.

4. **Singleton Pattern**: The context holder should be implemented as a singleton to ensure that only one instance exists in the JVM.

5. **Lazy Initialization**: Initialize the context data lazily, i.e., on the first usage. This can save resources if the context data is not needed.

6. **Documentation**: Document the usage of the context holder clearly, as it's a cross-cutting concern and can impact multiple parts of the application.

Here's a basic example of how you might implement a custom context holder in Java:

```java
public class CustomContextHolder {
    private static final ThreadLocal<Context> userContext = new ThreadLocal<>();

    public static void setContext(Context context) {
        userContext.set(context);
    }

    public static Context getContext() {
        return userContext.get();
    }

    public static void clearContext() {
        userContext.remove();
    }

    public static class Context {
        private final String userId;
        private final String vipLevel;
        private final BigDecimal walletBalance;

        public Context(String userId, String vipLevel, BigDecimal walletBalance) {
            this.userId = userId;
            this.vipLevel = vipLevel;
            this.walletBalance = walletBalance;
        }

        // getters
    }
}
```

In this example, `CustomContextHolder` is a utility class that provides static methods to set, get, and clear the context. The context data is stored in a `ThreadLocal` variable to ensure thread safety. The `Context` class is an immutable class that holds the context data.