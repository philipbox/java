<template>
    <div class="container main col-8">
		<!-- page-title start -->
		<!-- ================ -->
		<h1 class="page-title text-center">제품 정보</h1>
		<div class="separator with-icon">
			<i class="fa fa-shopping-bag bordered"></i>
		</div>
		<!-- page-title end -->
		<div class="image-box style-3-b">
			<div class="row">
				<div class="col-lg-4 col-xl-3">
					<div class="overlay-container">
						<img :src="getImg(f.img)" id="proImg" class="img-responsive" >
						<!-- <a class="overlay-link popup-img-single" href=""><i class="fa fa-search-plus"></i></a> -->
					</div>
				</div>
				<div class="col-lg-8 col-xl-7 pv-30">
					<table class="table">
						<tbody>
							<tr>
								<td width='100'>제품명</td>								
								<td>{{f.name}}</td>
							</tr>
							<tr>
								<td width='100'>제조사</td>
								<td>{{f.maker}}</td>
							</tr>
							<tr>
								<td width='100'>원재료</td>
								<td>{{f.material}}</td>
							</tr>
							<tr>
								<td width='100'>알레르기 성분</td>
								<td >{{f.allergy}}</td>
							</tr>
						</tbody>
					</table>
					<form class="clearfix row grid-space-10">
						<div class="form-group">
							<label>Quantity</label> <input type="text" class="form-control"
								id="qnt" name="qnt" value="1">
						</div>
					</form>
					<div class="product elements-list">
						<label> </label>
						<div class="btn-group">
							<a href="#" onclick="addIntakeFood(20)"
								class="btn btn-default btn-sm"><i class="fa fa-user pr-2"></i>
								추가</a> <a href="#" onclick="addIntakePrev(20)"
								class="btn btn-default btn-sm"><i class="fa fa-user pr-2"></i>
								찜</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<h4 class="space-top">영양 정보</h4>
		<div class="row">
			<div class="col-sm-6">
				<canvas id="pieChart" v-bind="ctxP" height="230"></canvas>
			</div>
			<div class="col-sm-6">
				<table class="table">
					<tbody>
						<tr>
							<td width='200'>일일 제공량</td>
							<td >{{f.supportpereat}}</td>
						</tr>
						<tr>
							<td width='200'>칼로리</td>
							<td>{{f.calory}}</td>
						</tr>
						<tr>
							<td width='200'>탄수화물</td>
							<td>{{f.carbo}}</td>
						</tr>
						<tr>
							<td width='200'>단백질</td>
							<td>{{f.protein}}</td>
						</tr>
						<tr>
							<td width='200'>지방</td>
							<td id="NC5">{{f.fat}}</td>
						</tr>
						<tr>
							<td width='200'>당류</td>
							<td id="NC6">{{f.sugar}}</td>
						</tr>
						<tr>
							<td width='200'>나트륨</td>
							<td id="NC7">{{f.natrium}}</td>
						</tr>
						<tr>
							<td width='200'>콜레스테롤</td>
							<td id="NC8">{{f.chole}}</td>
						</tr>
						<tr>
							<td width='200'>포화 지방산</td>
							<td id="NC9">{{f.fattyacid}}</td>
						</tr>
						<tr>
							<td width='200'>트렌스지방</td>
							<td id="NC10">{{f.transfat}}</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<!-- main end -->
	</div>
</template>

<script>
import 'http'
import http from "../http-common";
//import { Chart } from 'vue-chartjs'
import Chart from 'chart.js';
// import 'bootstrap'
// import 'bootstrap/dist/css/bootstrap.min.css'
// import 'bootstrap/dist/js/bootstrap.min.js'
	




export default {
    name: "Foodchart",
    props: ["code"],
  data() {
    return {
		upHere: false,
	f: null,
	loading: true,
	errored: false,
	ctxP: null,
	myPieChart: null
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
        getFood: function() {            
            http
                  .get("http://localhost:8090/api/food/chart/"+this.code)
                  .then(response => {
		this.f = response.data.f;		
})
                  .catch(()=>{
                      this.errored = true;

					})
					.finally(()=>{
						this.setChart();
					})
            //alert(this.code);
            

		},
		setChart: function(){
			var ctxP = document.getElementById("pieChart").getContext('2d');
			//var myPieChart = new 			
			new Chart(ctxP,
					{
						type : 'pie',
						data : {
							labels : [ "칼로리", "탄수화물", "단백질", "지방", "당류", "나트륨",
									"콜레스테롤", "포화 지방산", "트렌스지방" ],
							datasets : [ {
								data : [ this.f.calory, this.f.carbo, this.f.protein, 
									this.f.fat, this.f.sugar, this.f.natrium, 
									this.f.chole, this.f.fattyacid, this.f.transfat ],
								backgroundColor : [ 'rgba(255, 99, 132, 0.2)',
										'rgba(54, 162, 235, 0.2)',
										'rgba(255, 206, 86, 0.2)',
										'rgba(75, 192, 192, 0.2)',
										'rgba(153, 102, 255, 0.2)',
										'rgba(255, 159, 64, 0.2)',
										'rgba(255, 153, 255, 0.2)',
										'rgba(102, 0, 153, 0.2)',
										'rgba(51, 0, 0, 0.2)' ],
								borderColor : [ 'rgba(255, 99, 132, 1)',
										'rgba(54, 162, 235, 1)',
										'rgba(255, 206, 86, 1)',
										'rgba(75, 192, 192, 1)',
										'rgba(153, 102, 255, 1)',
										'rgba(255, 159, 64, 1)',
										'rgba(255, 153, 255, 1)',
										'rgba(102, 0, 153, 1)',
										'rgba(51, 0, 0, 1)' ],
								borderWidth : 1
							} ]
						},
						options : {
							scales : {
								yAxes : [ {
									ticks : {
										beginAtZero : true
									}
								} ]
							}
						}
					});
		}
    },

  mounted(){
    this.getFood();
      
  }


}
</script>