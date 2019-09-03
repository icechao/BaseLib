# BaseLib


## app基础架构封装


  基于mvp和mvvm的整合使用 mvp + rxAnrdoid + retrofit + databinding架构
  
  ### FrameLib MVP基础架构
  
  activity:做与页面相关的逻辑
  
  Presenter:数据源的处理,并与ViewModel关联,把数据源NetModel转换成Viewmodel
  
  Logic:数据源逻辑,返回数据源到Presenter中处理
  
  netModel:返回数据源
  
  viewModel:页面数据model,可以用接口的方式让NetModel来实现把两个model合成一个
            因为可能涉及到页面逻辑,建议尽量分开避免Model代码过于复杂
            
            
  如果两个很简单可以考虑使用同一个对象
  
  

 ## NetLib 网络框架独立于FrameLib
  
  基于RxAndroid + retrofit实现网络框架
  1. NetProvider 为网络请求对象生成
  2. ModelFilteredFactory为请求接口处理类
              ```ModelFilteredFactory.compose(NetProvider.getInstance("url",ApiService.class).getXXX(params)).subscribe(new SimpleSubscriber<Bean.class>(){...})```
              
              url : 服务器基础url
              ApiService: 服务器接口api类
              Bean.class: 返回数据解析bean
           
          
          
           

 ## Utils:分类别独立封装,分常用和不常用(暂未封装)
