<template>
    <div class="container">
		<div class="main col-md-12">
            <div class="hovereffect col-sm-12 col-md-6 col-lg-3" v-for="food in info" :key="food.code">
              
                <img :src="getImg(food.img)" style="width: 240px"
                    class="img-responsive" 
                        alt="">

                <div class="overlay responsive" >
							<h2>
                                {{ food.name }}
								<!-- ${l.getName() } -->
							</h2>
							<button class="info btn-light" v-on:click="goChart( food.code )" >상품정보보기</button>
						</div>
            </div>            

			<!-- <c:forEach items="${list}" var="l">
				<div class="hovereffect col-xs-12 col-md-6 col-lg-3">
					<img src="${l.getImg()}" 
                        style="width: 240px" 
                        onclick="getFood(${l.getCode()})"
                        class="img-responsive" 
                        alt="">
						<div class="overlay">
							<h2>
								${l.getName() }
							</h2>
							<button class="info btn-light" onclick="getFood(${l.getCode()})">상품정보보기</button>
						</div>
				</div>
	
			</c:forEach> -->
		
		</div>
	</div>
</template>

<script>

// import 'bootstrap'
// import 'bootstrap/dist/css/bootstrap.min.css'
//import 'bootstrap/dist/js/bootstrap.min.js'
//import 'bootstrap/dist/css/bootstrap-theme.min.css'
//import 'bootstrap/js'
import 'http'
import http from "../http-common";
export default {
  
    name: "MainList",
  data() {
    return {
      upHere: false,
      info: [],
      loading: true,
      errored: false
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
        }
    },

  mounted(){
      http
              .get("http://localhost:8090/api/food/list/%20")
              .then(response => (this.info = response.data.list))
              .catch(()=>{
                  this.errored = true;
              });
  }


}
</script>
