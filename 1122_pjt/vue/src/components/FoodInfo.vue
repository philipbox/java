<template>
  <div>
    <sidebar/>
    <div class="container">      
		<div class="main col-md-12" >
				<div class="col-md-12 col-lg-6" v-for="food in info" :key="food.code">
          <div>
					<div class="col-md-6 col-lg-4 col-xl-3">
						<img :src="getImg(food.img)" class="img-responsive" alt="">
					</div>
					<div class="col-md-6 col-lg-8 col-xl-9">
						<h3>
							<a v-on:click="goChart(food.code)" >{{food.name}} </a></h3>
						<p style="width: 300px; height: 100px; overflow: hidden;">{{food.material}}</p>
						<p>
							<button class="btn-info" v-on:click="add_side(food.code, food.name, food.natrium, food.fat, food.protein)" >추가</button>
							<button class="btn-success" style="margin-left: 5px;">찜</button>
						</p>
					</div>

          </div>
        



				</div>
        
                




		</div>
    
	</div>
          
  </div>





</template>
<script>
import 'http'
import http from "../http-common";
import sidebar from './FoodSidebar';
import { eventBus } from '../main';
export default {
    name: "MainList",
    components: {
      sidebar
    },
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
        },
        add_side(code, name, natrium, fat, protein){
          eventBus.$emit("add_side", name, code, natrium, fat, protein)
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