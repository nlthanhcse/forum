FORUM:
	service:
		user-service: port-8080
		category-service: port-8081
		post-service: port-8083
		comment-service: port- 8084
		user-comment-service: port-8086
		user-post-service: port-8085
	server:
		forum-user: port-8761
	API gateway
		forum-api-gatewat: port-8087
	database management system: MySQL
		database name: forum
		creation table sql file: forum-api-gateway/src/main/resources/forum-create-table.sql
		fake data sql file: forum-api-gateway/src/main/resources/forum-fake-data.sql

	

		
