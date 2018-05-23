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
* 加载
* 连接
    * 验证
    * 准备
    * 解析
* 初始化

####JVM运行时数据区
*   程序计数器(Program Counter Register)
    *   当前线程执行的字节码的行号指示器，通过改变此指示器来选取下一个需要执行的字节码指令
    *   在线程创建时创建
    *   每个线程拥有一个
    *   指向下一条指令的地址
*   方法区(Method Area(Non-Heap))
    *   线程共享
    *   存储
        *   类信息
        *   常量
        *   静态变量
        *   方法字节码
*   VM堆栈/本机方法堆栈(VM Stack / Native Method Stack)
    *   线程私有
    *   方法在执行时会创建一个栈帧（Stack Frame）用于存储局部变量表、操作数栈、动态链接、方法出口等信息
    *   方法从调用直至执行完成的过程，就对应着一个栈帧在虚拟机栈中入栈到出栈的过程
    *   局部变量表所需的内存空间在编译期间完成分配，而且分配多大的局部变量空间是完全确定的，在方法运行期间不会改变其大小
    *   出栈后空间释放
*   堆(Heap)
    *   线程共享
    *   存储对象或数组
    *   Heap划分
        *   年轻带
            *   eden(新生代)
            *   s0
            *   s1
        *   Tenured(老年代)
####指令重排

####Volatile
*   可见性

####Trace跟踪参数
*   -verbose:gc
        打印GC日志信息
*   -XX:+PrintGCDetails
        打印GC日志信息
*   -Xloggc:d:/gc.log 
        GC日志目录
*   -XX:+PrintHeapAtGC 
        每次一次GC后，都打印堆信息
*   -XX:+TraceClassLoading
        类加载信息
####Heap内存分配参数
*   -Xmx 
        最大堆
*   –Xms
        最小堆
*   -Xmn 
        新生代大小 （eden+2s)
*   –XX:NewRatio 
        年轻代（eden+2s）：老年代
*   –XX:SurvivorRatio  2s:eden 
####Stack内存分配参数
*   -Xss
    *   决定方法调用的深度
    *   没个线程独有栈空间
    *   参数，局部变量分配在栈上
    *   一般几百K就够了，64位jvm默认1M
####JVM内存回收
*   标记-清除算法
*   复制算法
*   标记-整理算法
*   分代收集算法

