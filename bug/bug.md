####javadoc生成文档时java.lang.IllegalArgumentException
*   javadoc生成文档时总是报java.lang.IllegalArgumentException错误,是classpath里面字符冲突引起的。
*   重新设置classpath去除其它环境变量的引用，直接使用目录名称，重新启动一下cmd或者IDE.。 

####导出javadoc时的“错误: 编码GBK的不可映射字符”问题
*   -encoding UTF-8 -charset UTF-8