#jvm管理
###JPS(Java虚拟机进程状态工具)
*   Java Virtual Machine Process Status Tool
*   -q
    *   指定jps只输出进程ID ，不输出类的短名称
*   -m 
    *   输出传递给Java进程（主函数）的参数
*   -l 
    *   输出主函数的完整路径
*   -v
    *   显示传递给JVM的参数
###jinfo(配置信息)
*   Configuration Info
*   -flag `<name>`
    *   打印指定JVM的参数值
*   -flag [+|-]`<name>`
    *   设置指定JVM参数的布尔值
*   -flag `<name>=<value>`
    *   设置指定JVM参数的值
###jmap(内存印象图)
*   Memory Map
*   -histo
    *   生成Java应用程序的堆快照和对象的统计信息
*   -dump 
    *   Dump堆详细信息，可以用于分析OOM导致的原因
*   -heap
    *   输出堆信息
###jstack 
*   Stack Trace 
    *   打印线程dump,发现线程目前停留在那行代码
*   -l
    *   打印线程锁信息
*   -F
    *   强制dump，当jstack没有响应时使用
###jstat(堆内存各部分的使用量)
*   -options 
    *   class (类加载器) 
    *   compiler (JIT) 
    *   gc (GC堆状态) 
    *   gccapacity (各区大小) 
    *   gccause (最近一次GC统计和原因) 
    *   gcnew (新生代统计)
    *   gcnewcapacity (新生代大小)
    *   gcold (老年代统计)
    *   gcoldcapacity (老年代大小)
    *   gcpermcapacity (永久区大小)
    *   gcutil (GC统计汇总)
    *   printcompilation (HotSpot编译统计)
*   jstat -gc <pid>: 可以显示gc的信息，查看gc的次数，及时间
    *   S0C 
        *   年轻代中第一个survivor（幸存区）的容量 (KB)
    *   S1C
        *   年轻代中第二个survivor（幸存区）的容量 (KB)
    *   S0U
        *   年轻代中第一个survivor（幸存区）目前已使用空间 (KB)
    *   S1U
        *   年轻代中第二个survivor（幸存区）目前已使用空间 (KB)
    *   EC
        *   年轻代中Eden（伊甸园）的容量 (KB)
    *   EU
        *   年轻代中Eden（伊甸园）目前已使用空间 (KB)
    *   OC 
        *   Old代的容量 (KB)
    *   OU 
        *   Old代目前已使用空间 (KB)
    *   PC
        *   Perm(持久代)的容量 (KB)
    *   PU
        *   Perm(持久代)目前已使用空间 (KB)
    *   YGC
        *   从应用程序启动到采样时年轻代中gc次数
    *   YGCT
        *   从应用程序启动到采样时年轻代中gc所用时间(s)
    *   FGC
        *   从应用程序启动到采样时old代(全gc)gc次数
    *   FGCT 
        *   从应用程序启动到采样时old代(全gc)gc所用时间(s)
    *   GCT
        *   从应用程序启动到采样时gc用的总时间(s)
###jconsole
###jvisualvm
