Create a REST API from a public image list from a Flickr public feed.

Among them are doing paging, and searching by tag or title.

Deployed via Heroku,
- To retrieve a public image from a flickr public feed:
https://obscure-ridge-56120.herokuapp.com/api/flickr-data/feed

- To do a search by tags/title by adding the parameters 'tag' and 'title'
https://obscure-ridge-56120.herokuapp.com/api/flickr-data/feed?tag=cat&title=cat

- To do paging by adding a path variable to the endpoint,
https://obscure-ridge-56120.herokuapp.com/api/flickr-data/feed/{page}
