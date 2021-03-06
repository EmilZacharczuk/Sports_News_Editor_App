import React, {Component} from 'react';
import ArticleList from '../../components/articles/ArticleList.js';
import Request from '../../helpers/request.js';
import CategoriesNavBar from '../../components/categories/CategoriesNavBar';

class CategoriesListContainer extends Component {

//props are passed in from app, set up a blank state to receive article to be passed down to components, edit and delete are bound at object scope and passed down to component
  constructor(props){
    super(props);
    this.state =
    {articles: [],
    categories: []}
    this.handleLink = this.handleLink.bind(this);
  }


  componentDidMount(){
    let categories = new Request();
    categories.get('/api/categories').then((data) => {
      this.setState({categories: data._embedded.categories})
    })
  }

  handleLink(id){
    let updateArticle = new Request();
    updateArticle.get('/articles/category/' + id).then((data) => {
      this.setState({articles:data})
    })

  }
  render(){
    if (!this.props.id)  {
      return (
        <div className="category-navbar">
          <CategoriesNavBar categories = {this.state.categories}/>
        </div>
      )
    }
    return (
      <div className="category-navbar">
        <CategoriesNavBar categories = {this.state.categories} handleLink={this.handleLink}/>
        <ArticleList articles={this.state.articles}/>
      </div>
    )

  }
}

export default CategoriesListContainer;
