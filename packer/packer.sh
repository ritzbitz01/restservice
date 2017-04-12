packer build example.json 2>&1 | tee output.txt
tail -2 output.txt | head -2 | awk 'match($0, /ami-.*/) { print substr($0, RSTART, RLENGTH) }' > ami.txt


#With user variables
packer build -var 'base_ami_id=ami-b9239baf' -var 'ami_app_name=GoCDRestServiceApp' -var 'app_pkg_name=restservice_0.0.5~SNAPSHOT_all.deb' -var 'pkg_install_loc=/home/ubuntu/restservice_0.0.5~SNAPSHOT_all.deb" example.json
