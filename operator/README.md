
## Install the operator sdk
```
go get -d github.com/operator-framework/operator-sdk
cd $GOPATH/src/github.com/operator-framework/operator-sdk
git checkout master
make dep
make install
```