FROM node:18.15.0-alpine3.17

ADD .output /app/ 

ENV NITRO_PORT 8080 

EXPOSE 8080

CMD ["node", "/app/server/index.mjs"]