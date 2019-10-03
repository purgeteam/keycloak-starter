#!/usr/bin/env bash
aliyunImgname=registry.cn-hangzhou.aliyuncs.com/engine/deepblue-api-gateway:latest

docker tag sha256:86cf17cc6178eb02e413c901edafdc9441b31506e51fe9cd038ede81aa6f6b1e $aliyunImgname

docker push $aliyunImgname

docker run --name api-gateway -d -p 4000:4000 \
  $aliyunImgname