# Spring Boot Sample for Spring Data Elasticsearch

* Run Elasticsearch with Docker

```
$ docker run -p 9201:9200 -p 9300:9300 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.9.0
```
