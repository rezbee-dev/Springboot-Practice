# Springboot-Practice
Project for learning Springboot

## Contributors
- risby
- -Mr Valentine

## Overview
- Based on CH 5 in *Spring in Action* - https://www.manning.com/books/spring-in-action-sixth-edition
- Covers
  - Autoconfiguring Spring Security
  - Defining custom user storage
  - Customizing the login page
  - Securing against CSRF attacks
  - Knowing your user

## Notes
- Adding Spring Security dependency automatically enables the following features:
  - All HTTP request paths require authentication
  - No specific roles or authorities are required
  - Authentication is prompted with a simple login page
  - There's only one user (`user`)
- Password encoders
  - `StandardPasswordEncoder` - deprecated 
  - `NoOpPasswordEncoder` - no encryption; good for testing 
- User Store
  - This allows you to add more than one user for authentication
  - Requires bean that implements `UserDetailsService` interface method `loadUserByUsername(String Username) throws UsernameNotFoundException`
  - in-memory user store
    - good for testing/ dev
    - Requires application to be redeployed to add new users
    - See `config.Webconfig` for an example