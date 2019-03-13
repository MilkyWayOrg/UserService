## User Service - Spring Boot REST API

### GET - http://localhost:7272/api/user

To get list of users

```markdown
Responses
- 200 ok
- 404 not found
```
### GET - http://localhost:7272/api/user/{userNameOrId}

To get a user by UserName or Id

```markdown
Responses
- 200 ok
- 404 not found
```

### POST - http://localhost:7272/api/user

To create a user

```markdown
Request
{
"userName":"PH00487322",
"name":"Prashanth H",
"role":"DEV",
"password":"12345"
}
```

```markdown
Responses
- 201 created
- 409 conflict
```

## H2 DB Console : http://localhost:7272/h2-console/
## Swagger Documentaion : http://localhost:7272/swagger-ui.html

