#JVM结构
####双亲委派模型
* 同一个类只会加载一次,防止开发者覆盖Java底层库
* 启动类加载器(Bootstrap):
    * 负责将 Java_Home/lib下面的类库加载到内存中（比如rt.jar）
* 标准扩展类加载器（Extension）:
    * 它负责将Java_Home /lib/ext或者由系统变量 java.ext.dir指定位置中的类库加载到内存中。
    * 开发者可以直接使用标准扩展类加载器
* 应用程序类加载器：（Application）
    * 它负责将系统类路径（CLASSPATH）中指定的类库加载到内存中。开发者可以直接使用系统类加载器。
    * 由于这个类加载器是ClassLoader中的getSystemClassLoader()方法的返回值，因此一般称为系统（System）加载器.
        
####类加载过程
    加载
