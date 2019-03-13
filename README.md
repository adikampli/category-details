
### Guides
The following guides illustrates how to use certain features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

### Rest Services
Fetch top categories --> http://localhost:6226/category

Fetch category levels based on depth --> http://localhost:6226/category/{depth}

Fetch specific category details --> http://localhost:6226/category/id/{categoryId}

Fetch products within category --> http://localhost:6226/category/id/{categoryId}/product

Fetch specific product details --> http://localhost:6226/product/id/{productId}