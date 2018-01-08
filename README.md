# 项目简介

1. 此商城项目，使用spring cloud 全家桶进行开发

2. 事务处理使用两种:强一致性(TCC),最终一致性(EDA)


## 使用技术

1. spring cloud eureka : 用于服务注册发现

2. spring data jpa : 数据库底层连接技术

3. spring mvc : 访问控制层技术

4. H2 : 内存式数据库，减少DB依赖 (正式环境时，可以直接切换至MYSQL)

## 项目分级

### 业务分级

此项目分为四个核心模块:

1. 用户模块(user-service):

1. 积分模块(score-service):

1. 产品模块(product-service):

1. 订单模块(order-service):


### 核心模块分层:

{模块名}-service-api: 微服务的模块api定义

{模块名}-service-core: 微服务的模块业务逻辑实现

{模块名}-service-db: 微服务的模块仓库


## 事务处理:



