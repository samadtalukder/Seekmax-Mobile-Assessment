FROM node:alpine

WORKDIR /usr/src/app

COPY package.json ./
COPY yarn.lock ./

RUN rm -rf node_modules

COPY . .

RUN yarn

RUN yarn build

RUN npm install --legacy-peer-deps

EXPOSE 3001

CMD ["yarn", "local"]

