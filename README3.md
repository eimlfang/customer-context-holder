# Spring SecurityContextHolder

使用了`TheadLocal`来存储`SecurityContext`, 保证在同一个线程中的方法都可以使用到`SecurityContext`。

使用`ThreadLocal`需要保证在线程使用完之后清除，SpringSecurity中的`FilterChainProxy`能保证 SecurityContext总是被清除。
