# Create a dockerfile
- Have docker: DONE
- Have a new folder: DONE
- Create an index.html file: 
- Create a Dockerfile: nginx/apache : OK
- Build image: > docker build -t imagename .
- Check image: > docker image ls
- Run locally: > docker run imagename 
- Expose port: > docker run -p 4<last 2 digits>0:80 imagename
- Go to docker hub and create account: get username (pmutisya)
- Tag our image: docker tag  imagename <username>/my-web 
- COnfirm tag: > docker image ls
- Log in on our laptop: > docker login
- Send image to registry (cloud) > docker push <username>/my-web
- Log in to docker hub and confirm image is there.
- ssh into server > ssh root@137.184.90.72
  - password

## In the server
- Pull Image into server: > docker pull username/imagename
- Run: docker run -p 4<last 2 digits>0:80 username/image-name
  - e.g KEN1234
  - docker run -p 4340:80 pmutisya/my-web
- Go to http://137.184.90.72:4340
- Terminate: Ctr+C
- docker run -d -p 4340:80 pmutisya/my-web
- CHeck running processes:
  - docker ps