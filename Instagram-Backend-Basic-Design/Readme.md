# Instagram Backend basic Design




### Feature
```
- User
    1. User can create new Account.
    2. User can sign In existing Account.
    3. Signed In User can upload multiple posts.
    4. Signed In User can get all posts .
    5. Signed In User can delete own post by postId.
    7. Signed In User can update his contact details (e.g:email,phone)
    8. Signed In User can changed his Account Password.
    9. Signed In User can logout from Account.
    10.Signed In User can delete own Account.

```

### Technologies Used
```
- Programming Language: Java
- Web Framework: SpringBoot
- Database : The project utilizes the MySQL database for data storage.
- Hibernate (for ORM)
- Maven (for dependency management)
```
### Data flow in Project
```
 Controller
    1.UserController
  Service
    1. UserService
    2. PostService
    3. Authentication Service
  Repository
    1. IUserRepo
    2. IPostRepo
    3. IAuthenticationTokenRepo
  Model
    1. User
    2. Post 
    3. AuthenticationToken

```

### Validation Rules
- User Email should be a normal Email like - ("something@something.com")
- User phoneNumber should be 10 digits only.

    
## Entity Relationships
- **Posts** and **User** have a **Many-to-One mapping**. Many Posts can be upload by a single User, but each post belongs to only one User.
- **Authentication Token** and **User** have a **One-to-One** mapping. Each token can have  associated with one User, and each User can be linked to only one Token at a time.
###  Conclusion
This is an Instagram Backend basic project that consists of many entities:  User, Post .From this project a valid User can do the CRUD operations with the posts.
In this project I used passwordEncryptor which save the password in database in hashCode.
This Project provide a email Authentication when a user sign in his Account , a Token received that user mail.This Token will be valid when till user is sign in his Account after sign out the token will be expired.
With the help of token the valid user can do CRUD operations .
The project utilizes different types of mappings between these entities to establish relationships and functionality within the system.

### Author
 👨‍💼 **Ankit Kumar**
 + Github : [Ankit kumar](https://github.com/ankitk55?tab=repositories)
 + Linkdin : [Ankit Kumar](https://www.linkedin.com/in/ankit-kumar-7300581b3/)
 
### 🤝 Contributing
Contributions, issues and feature requests are Welcome!\
Feel free to check [issues Page](https://github.com/issues) 

### Show Your Support 
 Give a ⭐ if this project help you!
