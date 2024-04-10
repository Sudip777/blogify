# Blogify App
Blogify is a web application designed to allow users to create, read, update, and delete blog posts. It provides functionality for managing users, categories, comments, and posts. This document provides an overview of the application's features, architecture, and usage.

## Features
- User Management: Users can create, update, and delete their accounts.
- Post Management: Users can create, update, delete, and view posts. Posts can be categorized.
- Category Management: Users can create, update, delete, and view categories for organizing posts.
- Comment Management: Users can add, and delete comments on posts.
## Technologies Used
- Java: The backend of the application is developed using Java programming language.
- Spring Boot: The application is built using the Spring Boot framework for Java.
- RESTful API: The application exposes RESTful APIs for communication between the frontend and backend.
- Hibernate: Hibernate is used for ORM (Object-Relational Mapping) for database operations.
- MySQL: MySQL is used as the relational database management system for storing application data.
## Controllers
1. UserController
 - Responsible for user-related operations such as creating, updating, deleting, and fetching users.

### Endpoints:
- POST /api/v1/users/create: Create a new user.
- PUT /api/v1/users/update/{userId}: Update an existing user.
- GET /api/v1/users/get/{userId}: Get a user by ID.
- GET /api/v1/users/all: Get all users.
- DELETE /api/v1/users/delete/{userId}: Delete a user by ID.
2. PostController
- Manages operations related to posts, including CRUD operations and fetching posts by user or category.

### Endpoints:
- POST /api/v1/post/create/user/{userId}/category/{categoryId}/posts: Create a new post.
- PUT /api/v1/post/update/{postId}: Update an existing post.
- DELETE /api/v1/post/delete/{postId}: Delete a post by ID.
- GET /api/v1/post/all: Get all posts.
- GET /api/v1/post/{postId}: Get a post by ID.
- GET /api/v1/post/all/{userId}/posts: Get all posts by a specific user.
- GET /api/v1/post/all/{categoryId}/posts: Get all posts in a specific category.
3. CategoryController
- Handles category-related operations such as creating, updating, deleting, and fetching categories.

### Endpoints:
- POST /api/v1/category/create: Create a new category.
- PUT /api/v1/category/update/{categoryId}: Update an existing category.
- GET /api/v1/category/get/{categoryId}: Get a category by ID.
- DELETE /api/v1/category/delete/{categoryId}: Delete a category by ID.
- GET /api/v1/category/all: Get all categories.
4. CommentController
- Manages comments on posts, including adding and deleting comments.

### Endpoints:
- POST /api/v1/comment/create/{postId}: Create a new comment for a post.
- DELETE /api/v1/comment/delete/{commentId}: Delete a comment by ID.
## Setup Instructions
- Clone the repository to your local machine.
- Configure the application properties, including the database connection details.
- Build and run the application using Maven or your preferred IDE.
- Access the application using the provided endpoints.
## Usage
- Create a user account using the /api/v1/users/create endpoint.
- Create categories using the /api/v1/category/create endpoint.
- Create posts using the /api/v1/post/create/user/{userId}/category/{categoryId}/posts endpoint.
- Add comments to posts using the /api/v1/comment/create/{postId} endpoint.
- Perform other CRUD operations using the provided endpoints as needed.
