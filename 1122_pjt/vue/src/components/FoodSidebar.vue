<template>
    
    <div style="width: 300px; float: right;">
        <div v-for="side1 in sideitem" :key="side1">
            <p> {{side1.name}} {{ side1.count }}
                <input type="button" class="btn-info" onclick="cartminus()" value="감소">
                <input type="button" class="btn-info" v-on:click="clearCode(side1.name)" value="초기화">
            </p>            
        </div>
        
		
		<br>
		<input type="button" class="btn-success" onclick="dailyCheck()" value="일일 영양소 확인">&nbsp;&nbsp;
        <input type="button" class="btn-info" v-on:click="clearAll()" value="전체초기화"><br>
		<br>
		<input type="button" class="btn-success" onclick="addEatFood()" value="내 섭취 정보에 추가">
		<br><br>

        <label style="font-size:100%; color:red;">나트륨 : {{NatRes}}</label><br>
        <label style="font-size:100%; color:red;">지방 : {{FatRes}}</label><br>
        <label style="font-size:100%; color:red;">단백질 : {{ProRes}}</label><br>
		

        
	<!-- <c:choose>
		<c:when test='${NatRes eq null}'>
			<label style="font-size:120%; color:red;"></label><br>
		</c:when>
		<c:otherwise>
			<label style="font-size:100%; color:red;">${NatRes}</label><br>
		</c:otherwise>
	</c:choose>
		
		
	<c:choose>
		<c:when test='${FatRes eq null}'>
			<label style="font-size:120%; color:red;"></label><br>
		</c:when>
		<c:otherwise>
			<label style="font-size:100%; color:red;">${FatRes}</label><br>
		</c:otherwise>
	</c:choose>
	
		<c:choose>
		<c:when test='${ProRes eq null}'>
			<label style="font-size:120%; color:red;"></label><br>
		</c:when>
		<c:otherwise>
			<label style="font-size:100%; color:red;">${ProRes}</label><br>
		</c:otherwise>
	</c:choose> -->
    

	</div>
</template>

<script>


import 'http'
import http from "../http-common";
import { eventBus } from "../main";

    
export default {
  
    name: "sidebar",
    created: function(){
        eventBus.$on("add_side", (value, code, natrium, fat, protein) => {
                this.add_sidebar(value, code, natrium, fat, protein);
            });
    },
  data() {
    return {
      upHere: false,
      info: [],
      sideitem: [],
      loading: true,
      errored: false,
      copy: [],
      NatRes: 0,
      FatRes: 0,
      ProRes: 0

    };
  },
    methods:{
        getMainList(){
            http
              .get("localhost:8090/list")
              .then(response => (this.info = response.list))
              .catch(()=>{
                  this.errored = true;
              })
        },
        getImg(pic){
          return require('../assets/'+pic)
        },
        goChart(code){
          this.$router.push("/foodchart/" + code);
          return;
        },
        get_sidebar(){
            alert("asdf");
            this.sidebar = this.$store.state.sideitems;
            var l = this.$store.state.sideitems.length;
            alert("asdf");
            this.$store.state.sideitems[l] = {item : "asdf", count : 3};
            alert(this.$store.state.sideitems[l].item);

        },
        add_sidebar(name, code, natrium, fat, protein){
            var l = this.sideitem.length;
            var t = false;
            for(var i=0;i<l;i++){
                if(this.sideitem[i].name == name){
                    this.sideitem[i].count++;
                    t = true;
                    break;
                }
            }
            if(!t){
                this.sideitem.push({"name":name, "count":1, "code":code, "natrium": natrium, "fat": fat, "protein" : protein});
            }
            this.NatRes += natrium;
            this.NatRes.toFixed(2);            
            this.FatRes += fat;
            this.FatRes.toFixed(2);
            this.ProRes += protein;
            this.ProRes.toFixed(2);

        },
        clearAll(){
            this.sideitem = [];
            this.NatRes = 0;
            this.NatRes.toFixed(2);            
            this.FatRes = 0;
            this.FatRes.toFixed(2);
            this.ProRes = 0;
            this.ProRes.toFixed(2);
        },
        clearCode(name){
            var l = this.sideitem.length;
            //var t = false;
            for(var i=0;i<l;i++){
                if(this.sideitem[i].name == name){
                    this.NatRes -= (this.sideitem[i].natrium).toFixed(2);
                    //this.NatRes.toFixed(2);            
                    this.FatRes -= (this.sideitem[i].fat).toFixed(2);
                    //this.FatRes.toFixed(2);
                    this.ProRes -= (this.sideitem[i].protein).toFixed(2);
                    //this.ProRes.toFixed(2);
                    this.sideitem[i].count--;
                    if(this.sideitem[i].count == 0){
                        alert("0")
                        this.copy = [];
                        //var jiter = 0;
                        for(var j = 0; j < l ; j++) {
                            if(i!=j) {
                                alert(this.sideitem[j].name);
                                //copy[jiter++].push(this.sideitem[j]);
                                this.copy.push({"name": this.sideitem[j].name, "count": this.sideitem[j].count, "code": this.sideitem[j].code, "natrium": this.sideitem[j].natrium, "fat": this.sideitem[j].fat, "protein" : this.sideitem[j].protein});
                            }
                            //if(this.sideitems[j].name == name){
                            //this.sideitems.splice(j, 1);
                            //}
                            
                        }
                        //alert("되나")
                        this.sideitem = [];
                        //alert(this.sideitems[0].natrium)                        
                        for(j = 0; j < l-1 ; j++) {
                            
                            //this.sideitem[j].push(copy[j]);
                            this.sideitem.push({"name": this.copy[j].name, "count": this.copy[j].count, "code": this.copy[j].code, "natrium": this.copy[j].natrium, "fat": this.copy[j].fat, "protein" : this.copy[j].protein});
                            //if(this.sideitems[j].name == name){
                            //this.sideitems.splice(j, 1);
                            //}
                            
                        }
                        //this.sideitems = copy;
                        alert("왜안돼")
                    }
                    
                    return;
                }
            }

        }


    },

  mounted(){
      //this.get_sidebar();
  }


}
</script>