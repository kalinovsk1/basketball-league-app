FROM node:19.5.0-alpine as builder

WORKDIR /app

COPY . .

RUN npm install
RUN npm run build

FROM nginx:1.23.3

EXPOSE 80

COPY  --from=builder /app/dist/user-app  /usr/share/nginx/html/
COPY default.conf.template /etc/nginx/templates/
