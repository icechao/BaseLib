# BaseLib
#app基础架构封装
  基于mvp和mvvm的整合使用mvp+databinding架构
  activity:做与页面相关的逻辑
  Presenter:数据源的处理,并与ViewModel关联,把数据源NetModel转换成Viewmodel
  Logic:数据源逻辑,返回数据源到Presenter中处理
  netModel:返回数据源
  viewModel:页面数据model,可以用接口的方式让NetModel来实现把两个model合成一个
            因为可能涉及到页面逻辑,建议尽量分开避免Model代码过于复杂
  如果两个很简单可以考虑使用同一个
 
#网络Lib还没有后期独立封装,返回数据源到
#Utils:分类别独立封装,分常用和不常用
